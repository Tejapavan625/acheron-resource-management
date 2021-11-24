package org.arm.resource.mngt.repository;

import org.arm.resource.mngt.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

}
