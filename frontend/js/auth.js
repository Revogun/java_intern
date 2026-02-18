const API = "http://localhost:8080/api/auth/login";


function generateToken(user) {
    return btoa(user.email + ":" + new Date().getTime());
}


function saveSession(user) {
    const token = generateToken(user);
    localStorage.setItem("token", token);
    localStorage.setItem("user", JSON.stringify(user));
}


function checkAuth() {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "login.html";
    }
}


function logout() {
    localStorage.clear();
    window.location.href = "login.html";
}
