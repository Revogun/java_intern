import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function Navbar() {
  return (
    <nav style={{ padding: "16px", background: "#1f2937", color: "white" }}>
      <h2 style={{ display: "inline" }}>HotelPro</h2>
      <span style={{ marginLeft: "20px" }}>
        <Link to="/" style={linkStyle}>Home</Link>
        <Link to="/rooms" style={linkStyle}>Rooms</Link>
        <Link to="/book" style={linkStyle}>Book</Link>
        <Link to="/login" style={linkStyle}>Login</Link>
      </span>
    </nav>
  );
}

const linkStyle = {
  color: "white",
  marginLeft: "15px",
  textDecoration: "none",
};

function Home() {
  return (
    <div style={pageStyle}>
      <h1>Welcome to HotelPro</h1>
      <p>Simple hotel management system frontend</p>
    </div>
  );
}

function Rooms() {
  return (
    <div style={pageStyle}>
      <h2>Available Rooms</h2>
      <div style={card}>
        <h3>Deluxe Room</h3>
        <p>₹2500 / night</p>
        <button>Book Now</button>
      </div>
    </div>
  );
}

function Book() {
  return (
    <div style={pageStyle}>
      <h2>Book a Room</h2>
      <input placeholder="Check-in Date" /><br /><br />
      <input placeholder="Check-out Date" /><br /><br />
      <button>Confirm Booking</button>
    </div>
  );
}

function Login() {
  return (
    <div style={pageStyle}>
      <h2>Login</h2>
      <input placeholder="Email" /><br /><br />
      <input placeholder="Password" /><br /><br />
      <button>Login</button>
    </div>
  );
}

const pageStyle = { padding: "20px" };
const card = {
  border: "1px solid #ccc",
  padding: "15px",
  width: "200px",
};

export default function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/rooms" element={<Rooms />} />
        <Route path="/book" element={<Book />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  );
}
