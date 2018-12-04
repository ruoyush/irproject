///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package IndexingLucene;
//
//import Classes.Job;
//import Classes.Path;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONNull;
//import net.sf.json.JSONObject;
///**
// *
// * @author mac
// */
//public class ReadJson {
//
//    @SuppressWarnings("finally")
//    private static List<Job> ReadJsonFile(){
//        String path="./data/data.json";
//        File file=new File(path);
//        BufferedReader reader=null;
//        String jsonContent="";
//        int count = 0;
//        List<Job> list = new ArrayList<Job>();
//        List<JSONObject> jsonObjList=new ArrayList<JSONObject>();
//        System.out.printf("Job load start...");
//        try {
//            reader=new BufferedReader(new FileReader(file));
//            String tempString=null;
//            while((tempString=reader.readLine())!=null){
////                System.out.println(tempString);
//                jsonContent+=tempString;
//            }
////            jsonContent="[{\"Job Title\": \"Sr. Tech Manager - App Prog (Distinguished Engineer - Java, J2EE)\", \"Company\": \"Oyster Tech Inc\", \"Location\": \"Charlotte, NC\", \"Summary\": \"   Job Summary   This is regarding a Urgent Job Opening  -* *Sr. Technical Manager - Application Prog (Distinguished Engineer)   -  Full Time Permanent.  Please go through the complete job description thoroughly. If you are interested, please go ahead and send me your most recent updated resume along with your  Contact#'s, Salary Expectation and your current location.   Please call me for more details...  Ph: 508-299-3009 or 508-425-7125.   Job Title =  Sr. Technical Manager - Application Prog (Distinguished Engineer)   Location =  Charlotte, NC   Position Type = Full Time Permanent  Base Salary = $140k/yr + $170k/yr (DOE) + Benefits  Bonus = NO  Are there flexible work hours = NO  Possibility of Remote Work = NO  Relocation Assistance Available = NO  Interview (FACE TO FACE) = YES  Candidate Type = NO VISAS -------- ONLY EAD or GC or US Citizens or TN1  ----------------------------------------------------------   Required Skills / Experience:    ---------------------------------------------------------------    Senior level technology manager  with track record of performance for managing &amp; influencing sophisticated, fast-paced business partners with competing priorities (previous experience as a  senior technical lead, senior architect or application manager of web applications)   Technical aptitude and knowledge of web technologies; deep knowledge of  Java and UI   Deep experience with  web based applications   Deep experience with  AGILE  Software development  Excellent partner &amp; teammate to peers; can influence &amp; resolve across organizational lines  Proven technology management discipline (  financials, resource planning, ops risk/security  )  Expert level knowledge of  Java/J2EE   Expert level knowledge of  Java, Hibernate, Web Services (SOAP and REST), Messaging, Struts, Spring, Spring batch and other Spring related technologies   Mid to expert level knowledge of  Front-End technologies including HTML, CSS and JavaScript   Experience with  Agile driven  development  Experience with  test-driven development  , placing a high value on modular design, unit testing and integration testing, including use of  JUnit and JavaScript unit testing frameworks   Experience with  RESTful Web Services utilizing JSON   Experience with S  pring frameworks, including Spring Security   Experience with  Responsive Web Design   Experience with  modern front-end approaches and frameworks (React, Angular, etc)   Financial Services Industry experience is a big plus.    ------------------------------------------------------    RESPONSIBILITIES:     ------------------------------------------------------    Manages a function or unit within the technology environment.  Manages associates and makes all decisions on personnel actions including staffing, performance management and compensation decision-making.  Supports multiple systems through maintenance, modification and problem resolution to support ongoing delivery of services and/or operations.  Manages multiple applications/ development projects, or single major complex initiatives if a small area of the development function.  Coordinates resources across various applications, operations or projects.  Manages budget, monitors progress and adjusts resources and priorities accordingly.  May provide expertise in determining the strategic technical direction and system architecture for initiatives. Provides input on policy issues.  Typically requires 7-10 years of applicable experience.  We are looking for a  Senior Web Development Technical Manager / Lead  with extensive experience in delivering high volume web applications.  This individual will lead a team of developers delivering in an  Agile operating model.  This individual is expected to work directly with key stakeholders to understand the business requirements and design/deliver complex solutions, while utilizing best practices in order to ensure high quality software solutions.  Responsible for leading application development for key sales technology initiatives, including consumer research and purchasing experiences.  Drive the successful rollout of sales flows to target state technology stack (Java and Browser technologies).  Design and enhance architecture solutions across Consumer Sales technology to ensure that our applications are stable, high-performing, and meet the needs of our customers.  Serves as a key technology partner to Digital Sales LOB.  Manages a large team (includes flex resources) working in a Lean-Agile execution model.  Understands client &amp; business partner feedback and works strategically with the business to evolve the technology enablement to create competitive advantage and improve client satisfaction in the marketplace.   Thanks for your time and have a wonderful day.Thanks,Suresh, Sr. Staffing Specialist / Recruiting Manager,Oyster Tech Inc,Ph: 508-299-3009(W),  Fax: 508-861-0278   Responsibilities and Duties    ------------------------------------------------------    RESPONSIBILITIES:     ------------------------------------------------------    Manages a function or unit within the technology environment.  Manages associates and makes all decisions on personnel actions including staffing, performance management and compensation decision-making.  Supports multiple systems through maintenance, modification and problem resolution to support ongoing delivery of services and/or operations.  Manages multiple applications/ development projects, or single major complex initiatives if a small area of the development function.  Coordinates resources across various applications, operations or projects.  Manages budget, monitors progress and adjusts resources and priorities accordingly.  May provide expertise in determining the strategic technical direction and system architecture for initiatives. Provides input on policy issues.  Typically requires 7-10 years of applicable experience.  We are looking for a  Senior Web Development Technical Manager / Lead  with extensive experience in delivering high volume web applications.  This individual will lead a team of developers delivering in an  Agile operating model.  This individual is expected to work directly with key stakeholders to understand the business requirements and design/deliver complex solutions, while utilizing best practices in order to ensure high quality software solutions.  Responsible for leading application development for key sales technology initiatives, including consumer research and purchasing experiences.  Drive the successful rollout of sales flows to target state technology stack (Java and Browser technologies).  Design and enhance architecture solutions across Consumer Sales technology to ensure that our applications are stable, high-performing, and meet the needs of our customers.  Serves as a key technology partner to Digital Sales LOB.  Manages a large team (includes flex resources) working in a Lean-Agile execution model.  Understands client &amp; business partner feedback and works strategically with the business to evolve the technology enablement to create competitive advantage and improve client satisfaction in the marketplace.   Thanks for your time and have a wonderful day.Thanks,Suresh, Sr. Staffing Specialist / Recruiting Manager,Oyster Tech Inc,Ph: 508-299-3009(W),  Fax: 508-861-0278   Qualifications and Skills   ----------------------------------------------------------   Required Skills / Experience:    ---------------------------------------------------------------    Senior level technology manager  with track record of performance for managing &amp; influencing sophisticated, fast-paced business partners with competing priorities (previous experience as a  senior technical lead, senior architect or application manager of web applications)   Technical aptitude and knowledge of web technologies; deep knowledge of  Java and UI   Deep experience with  web based applications   Deep experience with  AGILE  Software development  Excellent partner &amp; teammate to peers; can influence &amp; resolve across organizational lines  Proven technology management discipline (  financials, resource planning, ops risk/security  )  Expert level knowledge of  Java/J2EE   Expert level knowledge of  Java, Hibernate, Web Services (SOAP and REST), Messaging, Struts, Spring, Spring batch and other Spring related technologies   Mid to expert level knowledge of  Front-End technologies including HTML, CSS and JavaScript   Experience with  Agile driven  development  Experience with  test-driven development  , placing a high value on modular design, unit testing and integration testing, including use of  JUnit and JavaScript unit testing frameworks   Experience with  RESTful Web Services utilizing JSON   Experience with S  pring frameworks, including Spring Security   Experience with  Responsive Web Design   Experience with  modern front-end approaches and frameworks (React, Angular, etc)   Financial Services Industry experience is a big plus.   Thanks for your time and have a wonderful day.Thanks,Suresh, Sr. Staffing Specialist / Recruiting Manager,Oyster Tech Inc,Ph: 508-299-3009(W),  Fax: 508-861-0278  Job Type: Full-time  Salary: $140,000.00 to $170,000.00 /year  Required experience:   Java, j2EE: 6 years  Technical Management: 10 years  Front End dev, HTML, CSS, JavaScript, React, Angular: 6 years   \"},\n" +
////"{\"Job Title\": \"Lead Solution Architect\", \"Company\": \"Optomi\", \"Location\": \"Charlotte, NC\", \"Summary\": \"   Job Summary   Optomi, in partnership with a leading provider in digital financial services is seeking a Lead Solution Architect. This is a high-level enterprise-wide architecture opportunity focusing on the mapping of IT capabilities to business needs. The position provides technology leadership direction and accountability for strategic application architecture plans, system design, and implementation.   Lead Solution Architect Responsibilities:     Accountability for overall solution-level integrity of applications  Interact with a range of people, from highly technical software developers to Senior Executive stakeholders  Develop and maintain implementation plans for key aspects of enterprise architecture based on business requirements and IT strategies  Lead analysis of the current environment to detect critical deficiencies and drive solutions for improvement  Lead analysis of technology industry and market trends to determine their potential impact on the enterprise architecture  Provide technical leadership, guidance, and support in the deployment of complex applications in global distributed computing environments  Lead establishment of systems development protocols and/or selection of systems management approaches involving major company investments  Develop and ensure compliance with architecture principles and standards for the various systems and components based on design patterns  Work with project teams across the organization to develop and apply standards  Author and support the content for Solution Design Documents including Context Diagrams, Application Models, Application Profiles, Use Cases, Logical Application Models, Process Models, Logical Data Models, High Level Designs    Apply Today for This Job If Your Background Includes:     BS and 5 + years of formal architecture design and implementation experience  10+ years of software development experience  Excellent communication skills with ability to communicate at an executive level  Commanding knowledge with J2EE stack; JBoss/Fuse, WebLogic  Experience with open standards  SOA principles and technologies; SOAP, REST, XML, JSON, WSDL  Strong analytical and problem solving skills  Team builder and facilitator of cross team discussions with proven ability to identify and remove roadblocks and resolve issues  Understanding of industry trends and new technologies and ability to apply trends to architectural needs  Ability to effectively communicate with other senior leaders of IT on program strategies and plans and negotiate quality solutions.    Preferred Qualifications    Experience with Single Page Application (SPA) Architecture  Experience with Identity Management (IDM), SSO, oAuth, CA platforms (SiteMinder)  Certified Architecture Frameworks; TOGAF, FEAF, DOD, Zachman  Strong database design and development skills including data warehousing and ETL   Job Type: Full-time  Job Location:   Charlotte, NC   Required license or certification:   Do you require sponsorship to work in the US   \"}]";
//            JSONArray jsonArray = JSONArray.fromObject(jsonContent);
//            System.out.printf("Job success...");
//           // Job[] jobs = new Job[3];
//
//        for (int i = 0; i < jsonArray.size()-1; i++) {
//            String Jobtitle = "";
//            String Company = "";
//            String Location = "";
//            String Summary = "";
//            JSONNull jsonnull;
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            if(jsonObject.get("Job Title")!= JSONNull.getInstance()&& jsonObject.get("Company")!=JSONNull.getInstance()
//                    &&jsonObject.get("Location")!=JSONNull.getInstance() && jsonObject.get("Summary")!=JSONNull.getInstance()){
//            Jobtitle = (String) jsonObject.get("Job Title");
//            Company = (String) jsonObject.get("Company");
//            Location = (String) jsonObject.get("Location");
//            Summary = (String) jsonObject.get("Summary");
//            //System.out.println("Job Title:"+Jobtitle);
//            //System.out.println("Summary:"+Summary);
//            count++;
//            if(count%100==0){System.out.println("already load" +count+"documents");}
//            Job temp = new Job(Jobtitle,Company,Location,Summary);
//            list.add(temp);
//            }
//
//
//            //list.add((Job) JSONObject.toBean(jsonObject, Job.class));
//        }
//            System.out.printf("Job load success...");
//
//           // stus = (Student[]) JSONArray.toArray(jsonArray, Student.class);//转换成数组
//            //list = (List<Job>) JSONArray.toCollection(jsonArray, Job.class);//转换成列表
//                //
//                //JSONObject jo=JSONObject.fromObject(tempString);
//                //jsonObjList.add(jo);
//                //System.out.println("Job Title:"+jo.get("Job Title"));
//                //System.out.println("Company:"+jo.getJSONObject("_id").get("$oid"));
//                //System.out.println("Company:"+jo.get("Company"));
//                //System.out.println("Location:"+jo.get("Location"));
//        }
//         catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        finally {
//            if(reader!=null){
//            try {
//                reader.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            }
//            return list;
//        }
//
//    }
//
//    private static void WriteJson() {
//        JSONObject obj = new JSONObject();
//        obj.put("name", "jack");
//        obj.put("age", new Integer(20));
//        obj.put("balance", new Double(12.34));
//        obj.put("is_virgin", new Boolean(true));
//
//        JSONObject obj1 = new JSONObject();
//        obj1.put("name", "jack");
//        obj1.put("age", new Integer(20));
//        obj1.put("balance", new Double(12.34));
//        obj1.put("is_virgin", new Boolean(true));
//        obj1.put("hehe", obj);
//
//        System.out.println("obj1:" + obj1);
//        System.out.println("obj:" + obj);
//    }
//
//    public static void main(String[] args) throws IOException {
//        //WriteJson();
//        int count = 0;
//        List<Job> list = ReadJsonFile();
//        BufferedWriter bw = null;// write doc to disk
//        bw = new BufferedWriter(new FileWriter("data//Jobdoc"));
//        for (Job job : list) {
//
//	            bw.write("<DOC> "+ count +" </DOC>");
//                    count++;
//	            bw.newLine();
//                    bw.write("<JOBTITLE> "+ job.getJobTitle() + " </JOBTITLE>");
//                    bw.newLine();
//                    bw.write("<COMPANY> " + job.getCompany() + " </COMPANY>");
//                    bw.newLine();
//                    bw.write("<LOCATION> "+job.getLocation() + " </LOCATION>");
//                    bw.newLine();
//                    bw.write("<SUMMARY> "+job.getSummary()+ " </SUMMARY>");
//                    bw.newLine();
//                }
//        bw.flush();
//	bw.close();
//        System.out.println("Write finished");
//    }
//}
