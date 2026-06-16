const express = require("express");
const cors = require("cors");
const fs = require("fs");

const app = express();

app.use(cors());
app.use(express.json());
app.use(express.static("./"));

const DB_FILE = "db.json";

function readDB() {

    return JSON.parse(
        fs.readFileSync(
            DB_FILE,
            "utf8"
        )
    );

}

function writeDB(data) {

    fs.writeFileSync(
        DB_FILE,
        JSON.stringify(
            data,
            null,
            2
        )
    );

}

/* =========================
   COURSES
========================= */

app.get(
    "/api/courses",
    (req, res) => {

        const db = readDB();

        res.json(
            db.courses
        );

    }
);

/* =========================
   FACULTY
========================= */

app.get(
    "/api/faculty",
    (req, res) => {

        const db = readDB();

        res.json(
            db.faculty
        );

    }
);

/* =========================
   COURSE REGISTRATION
========================= */

app.post(
    "/api/register",
    (req, res) => {

        const db = readDB();

        const registration =
        req.body;

        registration.id =
        Date.now();

        db.registrations.push(
            registration
        );

        writeDB(db);

        res.json({

            success: true,

            message:
            "Registration Successful"

        });

    }
);

/* =========================
   GET ALL REGISTRATIONS
========================= */

app.get(
    "/api/registrations",
    (req, res) => {

        const db = readDB();

        res.json(
            db.registrations
        );

    }
);

/* =========================
   UPDATE REGISTRATION
========================= */

app.put(
    "/api/register/:id",
    (req, res) => {

        const db = readDB();

        const id =
        Number(req.params.id);

        const index =
        db.registrations.findIndex(
            item =>
            item.id === id
        );

        if (index === -1) {

            return res.status(404).json({

                success: false,

                message:
                "Registration Not Found"

            });

        }

        db.registrations[index] = {

            ...db.registrations[index],

            ...req.body

        };

        writeDB(db);

        res.json({

            success: true,

            message:
            "Registration Updated Successfully"

        });

    }
);

/* =========================
   DELETE REGISTRATION
========================= */

app.delete(
    "/api/register/:id",
    (req, res) => {

        const db = readDB();

        const id =
        Number(req.params.id);

        db.registrations =
        db.registrations.filter(
            item =>
            item.id !== id
        );

        writeDB(db);

        res.json({

            success: true,

            message:
            "Registration Deleted Successfully"

        });

    }
);

/* =========================
   CONTACT FORM
========================= */

app.post(
    "/api/contact",
    (req, res) => {

        const db = readDB();

        const message =
        req.body;

        message.id =
        Date.now();

        db.contactMessages.push(
            message
        );

        writeDB(db);

        res.json({

            success: true,

            message:
            "Message Sent Successfully"

        });

    }
);

/* =========================
   GET CONTACT MESSAGES
========================= */

app.get(
    "/api/contactMessages",
    (req, res) => {

        const db = readDB();

        res.json(
            db.contactMessages
        );

    }
);

/* =========================
   DASHBOARD COUNTS
========================= */

app.get(
    "/api/dashboard",
    (req, res) => {

        const db = readDB();

        res.json({

            totalCourses:
            db.courses.length,

            totalRegistrations:
            db.registrations.length,

            totalMessages:
            db.contactMessages.length,

            totalFaculty:
            db.faculty.length

        });

    }
);

/* =========================
   SERVER
========================= */

app.listen(
    3000,
    () => {

        console.log(
            "Server Running On Port 3000"
        );

    }
);