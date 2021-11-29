package org.arm.resource.mngt.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.Priority;
import org.arm.resource.mngt.entity.Status;
import org.arm.resource.mngt.service.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
	@Autowired
	private ICampaignService campaignService;
	
	@GetMapping("/campaignall")
	ResponseEntity<List<Campaign>> getCampaigns() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get");
		List<Campaign> camapaign = campaignService.getAllCampaign();
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(camapaign);
	}
	@PostMapping("/campaign/create")
	public void createCampaign(){
		Campaign campaign = new Campaign();
		campaign.setCampaignName("Campaign1");
		campaign.setCampaignOwner("Test");
		campaign.setCreateDate(new Timestamp(new Date().getTime()));
		campaign.setEndDate(new Timestamp(new Date().getTime() + 15*86400 ));
		campaign.setIsDeleted(0);
		campaign.setPriority(Priority.MEDIUM);
		campaign.setStatus(Status.IN_PROGRESS);
		campaign.setStartDate(new Timestamp(new Date().getTime()));
		
		campaignService.createCampaign(campaign);
		
	}
}
