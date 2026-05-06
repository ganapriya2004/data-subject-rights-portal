// ================= LOGIN =================
function login() {

    const username =
        document.getElementById("loginUsername").value.trim();

    const password =
        document.getElementById("loginPassword").value.trim();

    // VALIDATION
    if (!username || !password) {

        alert("Please fill all fields");

        return;
    }

    // LOGIN API
    fetch("http://localhost:8080/api/auth/login", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({

            username: username,

            password: password
        })
    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Invalid credentials");
        }

        return response.text();
    })

    .then(data => {

        console.log("LOGIN RESPONSE:", data);

        // SAVE USERNAME
        localStorage.setItem(
            "username",
            username
        );

        // SAVE LOGIN STATUS
        localStorage.setItem(
            "isLoggedIn",
            "true"
        );

        // ADMIN REDIRECT
        if (
            username.toLowerCase() === "admin"
        ) {

            window.location.href =
                "admin.html";

        }

        // USER REDIRECT
        else {

            window.location.href =
                "dashboard.html";
        }
    })

    .catch(error => {

        console.error(
            "LOGIN ERROR:",
            error
        );

        alert(
            "Invalid username or password"
        );
    });
}



// ================= REGISTER =================
function register() {

    const username =
        document.getElementById("regUsername").value.trim();

    const password =
        document.getElementById("regPassword").value.trim();

    if (!username || !password) {

        alert("Please fill all fields");

        return;
    }

    fetch("http://localhost:8080/api/auth/register", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({

            username: username,

            password: password
        })
    })

    .then(response => {

        if (!response.ok) {

            throw new Error("Registration failed");
        }

        return response.text();
    })

    .then(data => {

        alert(data);

        showLogin();
    })

    .catch(error => {

        console.error(error);

        alert("Registration failed");
    });
}



// ================= SHOW REGISTER =================
function showRegister() {

    document
        .getElementById("loginBox")
        .classList.add("hidden");

    document
        .getElementById("registerBox")
        .classList.remove("hidden");
}



// ================= SHOW LOGIN =================
function showLogin() {

    document
        .getElementById("registerBox")
        .classList.add("hidden");

    document
        .getElementById("loginBox")
        .classList.remove("hidden");
}



// ================= LOGOUT =================
function logout() {

    localStorage.clear();

    window.location.href =
        "login.html";
}