package com.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.model.Applicants;
import com.model.Companies;
import com.model.JobApplications;
import com.model.JobListings;
import com.service.ApplicantsService;
import com.service.CompaniesService;
import com.service.JobApplicationsService;
import com.service.JobListingService;

public class JobListingController {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		JobListingService jobListingService = new JobListingService();
		JobApplicationsService jobApplicationsService = new JobApplicationsService();
		ApplicantsService applicantService = new ApplicantsService();
		CompaniesService companyService = new CompaniesService();
		while (true) {

			System.out.println("1. Retrive jobs by company");
			System.out.println("2. Retrieves a list of all companies");
			System.out.println("3. Retrieves a list of all job listings");
			System.out.println("4. Retrieves a list of all applicants");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting..");
				break;
			}
			switch (input) {

			case 1:
				System.out.println("Enter company id");
				int companyid = sc.nextInt();
				List<JobListings> list2 = jobListingService.findAll(companyid);
				for (JobListings c : list2) {
					System.out.println(c);
				}
				break;

			case 2:
				List<Companies> com = companyService.findAll();
				for (Companies b : com) {
					System.out.println(b);
				}
				break;

			case 3:
				List<JobListings> jobListings = jobListingService.findAll();
				for (JobListings listing : jobListings) {
					System.out.println(listing);
				}

				break;

			case 8:
				List<Applicants> appli = applicantService.findAll();
				for (Applicants ab : appli) {
					System.out.println(ab);
				}
				break;
			}
		}
	}
}