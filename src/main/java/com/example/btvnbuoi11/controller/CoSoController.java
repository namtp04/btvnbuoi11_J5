package com.example.btvnbuoi11.controller;

import com.example.btvnbuoi11.entity.CoSo;
import com.example.btvnbuoi11.entity.TaiKhoanNganHang;
import com.example.btvnbuoi11.repository.CoSoRepository;
import com.example.btvnbuoi11.repository.TaiKhoanNganHangRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/co-so")
@RequiredArgsConstructor
@Slf4j
public class CoSoController {

    private final CoSoRepository coSoRepository;
    private final TaiKhoanNganHangRepository taiKhoanNganHangRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        model.addAttribute("lstCS", phanTrangList(page, model));
        return "list";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model, @RequestParam(required = false) Integer taiKhoanNganHang) throws Exception {
        List<TaiKhoanNganHang> lstTK = taiKhoanNganHangRepository.findAll();
        model.addAttribute("lstTK", lstTK);
//        if (taiKhoanNganHang != null) {
//            Optional<TaiKhoanNganHang> taiKhoanNganHangSelect = Optional.of(taiKhoanNganHangRepository.findById(taiKhoanNganHang))
//                    .orElseThrow(() -> new Exception("taiKhoan not found"));
//            model.addAttribute("nganHangSelect", taiKhoanNganHangSelect.get());
//        }else {
//            model.addAttribute("nganHangSelect", null);
//        }
        return "add";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("cs1") @Valid CoSo cs, BindingResult bindingResult, Model model) {
        List<TaiKhoanNganHang> lstTK = taiKhoanNganHangRepository.findAll();
        model.addAttribute("lstTK", lstTK);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", getErrorMessage(bindingResult));
            return "add";
        }
        CoSo cs1 = coSoRepository.findCoSoByMa(cs.getMa());
        if (cs1 != null) {
            model.addAttribute("error", "Trùng mã");
            return "add";
        }
        coSoRepository.save(cs);
        return "redirect:/co-so/hien-thi";
    }

    @GetMapping("remove/{ma}")
    public String xoa(@PathVariable("ma") Integer ma) {
        coSoRepository.deleteById(ma);
        return "redirect:/co-so/hien-thi";
    }

    @GetMapping("detail/{ma}")
    public String detail(@PathVariable("ma") Integer ma, Model model) {
        model.addAttribute("cs1", coSoRepository.findCoSoById(ma));
        return "detail";
    }

    @GetMapping("view-update/{ma}")
    public String viewUpdate(@PathVariable("ma") Integer ma, Model model) {
        model.addAttribute("lstTK", taiKhoanNganHangRepository.findAll());
        model.addAttribute("cs1", coSoRepository.findCoSoById(ma));
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("cs1") CoSo cs, Model model) {
        coSoRepository.save(cs);
        return "redirect:/co-so/hien-thi";
    }

    private List<CoSo> phanTrangList(Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<CoSo> lstCSPage = coSoRepository.findAll(pageable);
        model.addAttribute("totalPage", lstCSPage.getTotalPages());
        model.addAttribute("currentPage", page);
        return lstCSPage.getContent();
    }

    private Map<String, String> getErrorMessage(BindingResult bindingResult) {
        Map<String, String> error = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }
}
