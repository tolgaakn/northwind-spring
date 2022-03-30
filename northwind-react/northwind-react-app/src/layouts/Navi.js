import React, {useState} from "react";
import { useNavigate } from "react-router-dom";
import CartSummary from './CartSummary';
import { Button, Container, Menu } from "semantic-ui-react";
import SignedOut from "./SignedOut";
import SignedIn from "./SignedIn";
import { useSelector } from "react-redux";
import "react-toastify/dist/ReactToastify.min.css";

export default function Navi() {
  const { cartItems } = useSelector((state) => state.cart);
  const [isAuthenticated, setIsAuthenticated] = useState(true);
  const navigate = useNavigate();

  function handleSignOut() {
    setIsAuthenticated(false);
    navigate("/");
  }

  function handleSignIn() {
    setIsAuthenticated(true);
  }

  return (
    <div>
      <Menu inverted fixed="top">
        <Container>
          <Menu.Item name="home" />
          <Menu.Item name="messages" />

          <Menu.Menu position="right">
            {cartItems.length > 0 && <CartSummary></CartSummary>}
            
            {isAuthenticated ? <SignedIn signOut={handleSignOut} /> : <SignedOut signIn={handleSignIn}/>}
            
          </Menu.Menu>
        </Container>
      </Menu>
    </div>
  );
}