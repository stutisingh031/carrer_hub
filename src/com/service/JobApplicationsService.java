package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.JobApplicationsDao;
import com.daoimpl.JobApplicationsDaoImpl;
import com.model.JobApplications;
public class JobApplicationsService {
JobApplicationsDao dao = new JobApplicationsDaoImpl();

public  int save(JobApplications jobA) throws SQLException {
	// TODO Auto-generated method stub
	return dao.save(jobA);
}

public List<JobApplications> findAll(int jobid) throws SQLException {
	// TODO Auto-generated method stub
	return dao.findAll(jobid);
}
	
	}