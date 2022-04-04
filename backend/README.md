# Rowsport Reservation System - Backend



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
