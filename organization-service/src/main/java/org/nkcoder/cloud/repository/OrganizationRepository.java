package org.nkcoder.cloud.repository;

import org.nkcoder.cloud.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {

}
