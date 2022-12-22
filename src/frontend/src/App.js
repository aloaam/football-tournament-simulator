import logo from "./logo.svg";
import "./App.css";
import { Button } from "antd";
import { getTeamsInGroups } from "./client";

function App() {
  getTeamsInGroups()
    .then((res) => res.json())
    .then(console.log);

  return (
    <div className="App">
      <Button type="primary">Hello</Button>
    </div>
  );
}

export default App;
