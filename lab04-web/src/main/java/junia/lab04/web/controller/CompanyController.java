package junia.lab04.web.controller;
import junia.lab04.core.entity.Company;
import junia.lab04.core.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class CompanyController {

    @Inject
    private CompanyService companyService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap){
        modelMap.put("companies",this.companyService.findAllWithProjects());
        return  "companiesList";
    }

    @RequestMapping(path = "/{id}/delete", method=RequestMethod.GET)
    public String submitdelete(@PathVariable int id){
        this.companyService.deleteById(id);
        return "redirect:../list";
    }

    @RequestMapping(path = "/form")
    public String getform(ModelMap modelMap){
        modelMap.put("company",new Company());
        return "companyForm";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String submitForm (@ModelAttribute("company") Company company){
        this.companyService.save(company);
        return "redirect:list";
    }
}
