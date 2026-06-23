import React from "react";

function App() {

  const students = [
    { id: 1, name: "BNU", age: 20, rollNo: "23B81A05CD", cgpa: 9.1 },
    { id: 2, name: "Jan", age: 21, rollNo: "23B81A05CQ", cgpa: 8.8 },
    { id: 3, name: "CNU", age: 20, rollNo: "23B81A05DW", cgpa: 9.4 },
    { id: 4, name: "sURYA", age: 22, rollNo: "23B81A05DN", cgpa: 8.9 },
    { id: 5, name: "roHIT", age: 21, rollNo: "23B81A05DH", cgpa: 9.3 },
    { id: 6, name: "chaRAN", age: 20, rollNo: "23B81A05CF", cgpa: 8.7 }
  ];

  return (
    <div>
      <h1>Student Details</h1>

      <table border="1" cellPadding="10">
        <thead>
          <tr>     
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Roll No</th>
            <th>CGPA</th>
          </tr>
        </thead>

        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.age}</td>
              <td>{student.rollNo}</td>
              <td>{student.cgpa}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;