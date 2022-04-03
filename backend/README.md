# Rowsport Reservation System
## Main goal

This program shall serve as a reservation system for sports courses via web-browser interface. It will contain various types of courses and enable the users to sign up to a course according to their skill level. The skill levels will be tracked automatically based on internal logic (amount of courses passed, value can be overridden by Administrator). Signup will be matched with the users' available prepaid credit, which will be subtracted from the users' accounts automatically on a preset time (to prevent signing off from the selected course on too short notice - e.g. 20 hours before the time the course takes place). The lessons will be tracked in a persisted calendar (not implemented yet, work in progress).

## Backend 

**Logic and roles** - *authorization of each role is governed through **Spring Security Roles***

- **User** (everybody after registering); each User can be assigned roles, the .

- **Student** (can apply for courses and view their trackrecord; is automatically assigned to User upon registration through the public /registration endpoint)
- **Teacher** (is assigned to courses by Admin)
- **Admin** (can add credit to Student, assign or remove Student to/from a Course, create and remove new Course in the calendar, assign role of Teacher to User)
- **Superadmin** (can assign roles of Teacher, Admin and Student to User)

Students, Teachers will be persisted in database separately, to keep their record of Courses and Users' personal details.

**Functionalities:**

- automatic withdrawal of the course price from the student's credit upon course time elapses
- automatic change of the student's skill level according to the amount of courses passed
- students will be able to see / apply for only the courses appropriate to their skill level

## Frontend

The frontend part will be a web-browser based interface made in JavaScript (Vue.js).

**Visible by everyone:**
- Register / Log-in page

**Visible by User-Student:**
- Simple calendar where each day will provide clear view of courses available to the student.
- Upon clicking on the course, detail of the course will be shown (e.g. how many people are signed up, number of placements available)
- Student Detail - here the student will be able to see their credit balance, their rank, and their total courses passed

**Visible by Teacher:**
- Simple calendar showing them their assigned lessons. The view will also show all other courses.

**Visible by Admin**
- Simple calendar with all courses.
- Upon clicking the course, detailed view will pop-up, where the admin will be able to remove students, add students, assign / remove teacher.
- Upon clicking on a Day, the Admin will be able to add courses and edit their level, amount of placements, add students, assign / remove teacher.
- List of all students and their details
- interface for adding / removing roles of Teacher

**Visible by Superadmin**
- all of the above, also interface for adding / removing roles of Admin and Teacher


