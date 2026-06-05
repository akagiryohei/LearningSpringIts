package com.example.its.web.issue;

import com.example.its.domein.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm issueForm) {
        return "issues/creationForm";
    }

    @PostMapping
    public String create(@Validated IssueForm issueForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(issueForm);
        }
        issueService.create(issueForm.getSummary(), issueForm.getDescription());
        return "redirect:/issues";
    }

    @GetMapping("{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {

//        IssueEntity dummyEntity = new IssueEntity(1, "概要", "説明");
        var issue = issueService.findById(id);
        model.addAttribute("issue", issueService.findById(id));
        return "issues/detail";
    }
}
