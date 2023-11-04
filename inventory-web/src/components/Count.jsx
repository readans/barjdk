import { useEffect, useState } from "react";

function Count({ initialValue = 0, minValue, maxValue, onChange }) {
  const [count, setCount] = useState(initialValue);

  useEffect(() => {
    if (onChange !== undefined) onChange(count);
  }, [count]);

  return (
    <div className="flex items-center justify-between bg-zinc-800 p-1 rounded-full gap-x-2 text-white text-lg select-none">
      <span
        className="bg-white p-1 rounded-full text-black cursor-pointer"
        onClick={() => {
          if (minValue !== undefined && count - 1 < minValue) return;
          setCount((value) => value - 1);
        }}
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={1.5}
          stroke="currentColor"
          className="w-4 h-4"
        >
          <path strokeLinecap="round" strokeLinejoin="round" d="M19.5 12h-15" />
        </svg>
      </span>
      {count}
      <span
        className="bg-white p-1 rounded-full text-black cursor-pointer"
        onClick={() => {
          if (maxValue !== undefined && count + 1 > maxValue) return;
          setCount((value) => value + 1);
        }}
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={1.5}
          stroke="currentColor"
          className="w-4 h-4"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M12 4.5v15m7.5-7.5h-15"
          />
        </svg>
      </span>
    </div>
  );
}

export default Count;
