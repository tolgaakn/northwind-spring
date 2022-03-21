import React from "react";
import { Dropdown, Image, Menu } from "semantic-ui-react";

export default function SignedIn(props) {
  return (
    <div>
      <Menu.Item>
        <Image
          avatar
          spaced="right"
          src="https://upload.wikimedia.org/wikipedia/commons/6/6e/%C3%96rnek.jpg"
        />
        <Dropdown pointing="top left" text="Tolga">
          <Dropdown.Menu>
            <Dropdown.Item text="Bilgilerim" icon="info" />
            <Dropdown.Item onClick={props.signOut} text="Çıkış Yap" icon="sign-out" />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </div>
  );
}
