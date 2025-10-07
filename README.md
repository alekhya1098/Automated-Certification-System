# 🚀 Automated Certification System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white)
![Status](https://img.shields.io/badge/Project%20Type-Academic-blue?style=for-the-badge)


---

An Android-based application developed to automate the college certificate issuing process.  
This system allows students to apply for certificates online and enables administrators to approve or reject requests efficiently, reducing manual effort and improving transparency.

---

## 📘 Project Overview

In traditional college systems, students must physically visit the institution to apply for certificates (such as Bonafide, ID Card, Bus Pass, or Marks Memo) and check their due clearances.  
The **Automated Certification System** replaces this manual process with an online platform that enables:

- Students to apply for certificates remotely.  
- Administrators to verify requests and send updates via email notifications.  
- Streamlined tracking of application status, reducing time and paperwork.

---

## 🧩 Features

### 👨‍🎓 Student Module
- Register and log in securely.
- Apply online for certificates (Bonafide, Memo, ID Card, Bus Pass).
- View application status updates in real time.

### 🧑‍💼 Admin Module
- Approve or reject student registrations.
- View and manage certificate requests.
- Notify students of approval via email.
- Maintain branch-wise student data.

---

## 🖥️ System Architecture

- **Frontend:** XML (Android UI)
- **Backend:** Java (Android)
- **Database:** SQLite
- **Server:** Apache Tomcat
- **IDE:** Android Studio

---

## ⚙️ Software Requirements

| Component | Specification |
|------------|----------------|
| Operating System | Windows 7/10 |
| Language | Java |
| Toolkit | Android SDK |
| Database | SQLite |
| IDE | Android Studio |

---

## 💻 Hardware Requirements

| Component | Minimum Requirement |
|------------|----------------------|
| Hard Disk | 500 GB |
| RAM | 512 MB |

---

## 🧠 Technologies Used

- **Java** – Core language for Android application logic.  
- **SQLite** – Lightweight embedded database for local data storage.  
- **XML** – UI layout design.  
- **Android SDK** – Development and testing framework.

---

## 📋 UML Diagrams

The project includes various UML diagrams for design and analysis:
- **Use Case Diagram** – Shows system interactions between Admin and Student.  
- **Class Diagram** – Represents system structure and relationships.  
- **Sequence Diagram** – Depicts message flow between objects.  
- **Activity Diagram** – Visualizes workflow for login, apply, and approval actions.


---
| Description             | Screenshot                                                |
| ----------------------- | --------------------------------------------------------- |
| **Main Screen**         | ![Main Screen](screenshots/main.png)                      |
| **Admin Login**         | ![Admin Login](screenshots/admin_login.png)               |
| **Student Login**       | ![Student Login](screenshots/student_login.png)           |
| **Certificate Request** | ![Certificate Request](screenshots/apply_certificate.png) |
| **Admin Approval**      | ![Admin Approval](screenshots/admin_approval.png)         |

---
## 🧪 Testing

- Unit testing for individual modules (Admin, Student).  
- Integration testing to verify module interactions.  
- System testing for overall functionality.  
- User acceptance testing to ensure real-world usability.

---

## 📱 Application Flow & Results

This section demonstrates the overall working of the **Automated Certification System**, showing how both **Admin** and **Student** users interact with the application.

---

### 🏠 Main Screen

When the **Admin or Student** opens the application, they are greeted with the main home screen.

📱 **Features:**
- Users can choose whether to log in as **Admin** or **Student**.
- The UI is clean and user-friendly, designed for easy navigation.

---

### 🔐 Admin Login

After choosing **Admin Mode**, the admin must log in using valid credentials.

📱 **Features:**
- Secure login for administrators.
- Incorrect login attempts prompt a validation message.

---

### 🧭 Admin Dashboard

Once logged in, the admin selects the **branch** (e.g., CSE, ECE, EEE, ME, CE, IT) they want to manage.

📱 **Features:**
- Branch-wise student management.
- Admin can view all students in the selected department.

---

### 👩‍💼 Admin Functionalities

After selecting a branch, the admin can:
- View registered students.
- Approve or reject student registrations.
- View certificate requests from students.
- Approve or reject certificate applications (e.g., Bonafide, ID Card, Memo, Bus Pass).

#### Options available:
1. **View Students**
   - Displays a list of all registered students.
2. **Approved Students**
   - Shows students who have been approved by the admin.

#### Example:
If a student applies for a Bonafide certificate, the admin can:
- View the student’s details and request reason.
- Approve or reject the request.
- Once approved, the student is notified and the status is updated.

✅ **After approval**, the system redirects back to the **Admin Home Page** with updated status.

---

### 👨‍🎓 Student Login

Students can log in with their credentials or choose to **register** if they are new users.

📱 **Features:**
- Secure registration form with fields such as Name, Email, Password, ID, Mobile Number, and Branch.
- Registration details are saved to the database and await admin approval.

---

### 🧾 Student Home Page

After logging in, the student is redirected to the **Student Dashboard**.

Available options:
1. **Apply for Certificate**
2. **View Status**
3. **Logout**

---

### 📝 Applying for Certificates

When the student selects **Apply**, they can choose from available certificate types:
- Bonafide Certificate
- ID Card
- Bus Pass
- Memo

📱 **Features:**
- Simple form to request certificates.
- Students can enter a short reason for their request (e.g., *“Need Bonafide for RTC pass”*).

After submission, the request is stored in the database and visible to the admin for review.

---

### ⏳ Checking Application Status

Students can check the **status** of their certificate requests from the dashboard.

📱 **Possible Statuses:**
- `Waiting for Approval`
- `Approved`
- `Rejected`

---

### ✅ Admin Approval Process

Once the admin reviews the request:
- If **approved**, the student’s application status updates to “Approved.”
- If **rejected**, the student’s application shows “Rejected” with remarks.

This ensures transparent communication between the student and admin.

---

### 🏁 Final Outcome

- The entire process — from student request to admin approval — happens online.
- Reduces the need for manual paperwork or in-person visits.
- Speeds up certificate delivery and improves user satisfaction.

---

### 🖼️ Screenshots (for GitHub visualization)

| Stage | Screenshot |
|--------|-------------|
| Main Screen | ![Main Screen](screenshots/main_screen.png) |
| Admin Login | ![Admin Login](screenshots/admin_login.png) |
| Admin Branch Selection | ![Admin Branch](screenshots/admin_branch.png) |
| Student Request View | ![Request View](screenshots/student_request.png) |
| Admin Approval | ![Admin Approval](screenshots/admin_approval.png) |
| Student Registration | ![Student Register](screenshots/student_register.png) |
| Student Home Page | ![Student Home](screenshots/student_home.png) |
| Apply for Certificate | ![Apply Certificate](screenshots/apply_certificate.png) |
| Status View | ![Status View](screenshots/status_view.png) |

> 🖼️ *Place all images inside a `/screenshots` folder in your project root.*

---

### 🎯 Summary

The **Automated Certification System** successfully digitizes the certificate request workflow for educational institutions.  
Both Admin and Students can interact through a simple, effective Android interface that automates:
- Registration
- Application Submission
- Approval/Rejection
- Status Tracking

Resulting in a **faster**, **paperless**, and **user-friendly** experience for all.

---


