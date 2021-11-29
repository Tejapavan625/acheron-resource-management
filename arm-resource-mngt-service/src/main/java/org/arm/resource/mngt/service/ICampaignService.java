package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.exceptions.CampaignNotFoundException;

public interface ICampaignService {

     public List<Campaign> getAllCampaign() throws CampaignNotFoundException;

	public void createCampaign(Campaign campaign);

	public Campaign findById(int l);
}
