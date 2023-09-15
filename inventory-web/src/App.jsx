import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <h1>Hello</h1>
      <button
        onClick={() => setCount((c) => c + 1)}
        className="px-4 py-2 bg-blue-700 text-white border-black border-2 rounded-lg"
      >
        {count}
      </button>
    </>
  );
}

export default App;
