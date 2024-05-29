package com.example.btvnbuoi11.controller;

import com.example.btvnbuoi11.entity.CoSo;
import com.example.btvnbuoi11.repository.CoSoRepository;
import com.example.btvnbuoi11.repository.TaiKhoanNganHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/co-so")
@RequiredArgsConstructor
public class CoSoController {

    private final CoSoRepository coSoRepository;
    private final TaiKhoanNganHangRepository taiKhoanNganHangRepository;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        model.addAttribute("lstCS",phanTrangList(page,model));
        return "list";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model){
        model.addAttribute("lstTK",taiKhoanNganHangRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String add(CoSo cs){
        coSoRepository.save(cs);
        return "redirect:/co-so/hien-thi";
    }

    @GetMapping("remove/{ma}")
    public String xoa(@PathVariable("ma") Integer ma){
        coSoRepository.deleteById(ma);
        return "redirect:/co-so/hien-thi";
    }

    @GetMapping("detail/{ma}")
    public String detail(@PathVariable("ma") Integer ma,Model model){
        model.addAttribute("cs1",coSoRepository.findCoSoById(ma));
        return "detail";
    }

    @GetMapping("view-update/{ma}")
    public String viewUpdate(@PathVariable("ma")Integer ma,Model model){
        model.addAttribute("cs1",coSoRepository.findCoSoById(ma));
        return "update";
    }

    @PostMapping("update")
    public String update(CoSo cs){
        coSoRepository.save(cs);
        return "redirect:/co-so/hien-thi";
    }

    private List<CoSo> phanTrangList(Integer page,Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<CoSo> lstCSPage = coSoRepository.findAll(pageable);
        model.addAttribute("totalPage",lstCSPage.getTotalPages());
        return lstCSPage.getContent();
    }
}
