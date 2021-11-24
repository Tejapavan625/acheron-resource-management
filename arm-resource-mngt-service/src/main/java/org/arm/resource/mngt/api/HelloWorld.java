package org.arm.resource.mngt.api;

import java.util.ArrayList;
import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Project;
import org.arm.resource.mngt.service.ICampaignService;
import org.arm.resource.mngt.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@Value("${config.message:Config Server is not working. Please check...}")
	private String msg;

	@Autowired
	private ICampaignService campaignService;
	
	@Autowired
	private IProjectService projectService;
	@RefreshScope
	@GetMapping("/employees")
	List<Employee> all() {

		List<Employee> elist = new ArrayList<>();
		Employee e = new Employee();
		//e.setName(msg);
		e.setName("Ayan");
		elist.add(e);
		return elist;
	}
@GetMapping("/c")
public List<Campaign> allC(){
	return campaignService.getAllCampaign();
}

@GetMapping("/t")
public List<Project> allt(){
	return projectService.getAllProject();
}

}
