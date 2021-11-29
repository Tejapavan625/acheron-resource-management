package org.arm.resource.mngt.service;

import java.util.List;

import org.arm.resource.mngt.entity.Campaign;
import org.arm.resource.mngt.entity.ExceptionMessage;
import org.arm.resource.mngt.exceptions.CampaignNotFoundException;
import org.arm.resource.mngt.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService implements ICampaignService {
	@Autowired
	CampaignRepository campaignRepository;

	public List<Campaign> getAllCampaign() {
	List<Campaign> campaignList=campaignRepository.findAll();
	if(campaignList.isEmpty()) {
		throw new CampaignNotFoundException(ExceptionMessage.CampaignDataEmpty.getMessage());
	}
		
		return campaignList;

	}

	@Override
	public void createCampaign(Campaign campaign) {
		campaignRepository.save(campaign);
	}

	@Override
	public Campaign findById(int l) {
		Campaign campaign= campaignRepository.findById(l).get();
		if(campaign==null) {
			throw new CampaignNotFoundException(ExceptionMessage.CampaignIdNotFound.getMessage());
		}
		return campaign;
	}

}
