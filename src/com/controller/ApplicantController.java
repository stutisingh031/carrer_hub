package com.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import com.model.JobApplications;
import com.model.JobListings;
import com.service.ApplicantsService;
import com.service.CompaniesService;
import com.service.JobApplicationsService;
import com.service.JobListingService;

public class ApplicantController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JobListingService jobListingService = new JobListingService();
		JobApplicationsService jobApplicationsService = new JobApplicationsService();
		ApplicantsService applicantService = new ApplicantsService();
		CompaniesService companyService = new CompaniesService();

		while (true) {
			System.out.println("1. Applicant Id and Job ID");
			System.out.println("2. Post Job");
			System.out.println("3. List Applicants  each Job");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting..");
				break;
			}
			switch (input) {
			case 1:

				JobApplications jobA = new JobApplications();
				List<JobListings> list;
				try {
					list = jobListingService.findAll();
					for (JobListings p : list) {
						System.out.println(p);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Random random = new Random();
				int randomNumber = random.nextInt();
				int application_id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
				jobA.setApplicationId(application_id);
				System.out.println(application_id);
				System.out.println("Enter Job Id");
				jobA.setJobId(sc.nextInt());
				System.out.println("Enter Applicant Id");
				jobA.setApplicantID(sc.nextInt());

				LocalDateTime currentDate = LocalDateTime.now();
				String ApplicationDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // "YYYY-MM-DD"
				System.out.println("Order_date:" + ApplicationDate);
				jobA.setApplicaionDate(ApplicationDate);

				System.out.println("Enter Cover Letter");
				String coverLetter = sc.nextLine(); 
				coverLetter = sc.nextLine(); 
				jobA.setCoverLetter(coverLetter);
				
				try {
					jobApplicationsService.save(jobA);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					
				}
				System.out.println("Applied...");

				break;

			case 2:
				JobListings jobl = new JobListings();
				Random random1 = new Random();
				int randomNumber1 = random1.nextInt();
				int job_id = randomNumber1 < 0 ? randomNumber1 * -1 : randomNumber1;
				jobl.setJobId(job_id);

				System.out.println("Enter Company Id");
				jobl.setComplanyId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter Job Title");
				jobl.setJobTitle(sc.nextLine());
				

				System.out.println("Enter Job Description");
				jobl.setJobDescription(sc.nextLine());
				

				System.out.println("Enter Job Location");
				jobl.setJobLocation(sc.nextLine());
			

				System.out.println("Enter Salary");
				jobl.setSalary(sc.nextDouble());
				sc.nextLine();
				System.out.println("Enter Job Type");
				jobl.setJobType(sc.nextLine());
			

				LocalDateTime currentDate1 = LocalDateTime.now(); // the current date
				String PostedDate = currentDate1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // "YYYY-MM-DD"
				System.out.println("Post_date:" + PostedDate);
				jobl.setPostedDate(PostedDate);

				try {
					jobListingService.save(jobl);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
				System.out.println("Added to job Listing...");
				break;

			case 3:
				System.out.println("Enter Job id");
				int jobid = sc.nextInt();
				List<JobApplications> list3;
				try {
					list3 = jobApplicationsService.findAll(jobid);
					for (JobApplications a : list3) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break;

			}
		}
	}
}
