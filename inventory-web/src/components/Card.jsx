import { useState } from "react";

function Card({ item, children, selectable, onSelect }) {
  const [selected, setSelected] = useState(false);

  const handleSelect = () => {
    if (!selectable) return;
    setSelected((selected) => !selected);
    onSelect(item);
  };

  return (
    <div
      className={`flex p-3 rounded-lg shadow-sm ${
        selected ? "bg-gray-200" : "bg-white"
      } ${selectable && "cursor-pointer"}`}
      onClick={() => handleSelect()}
    >
      <div className="flex flex-grow gap-x-3">
        <div className="h-20 aspect-square bg-blue-900 rounded-md grid place-items-center text-white">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="w-10"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M21 7.5l-9-5.25L3 7.5m18 0l-9 5.25m9-5.25v9l-9 5.25M3 7.5l9 5.25M3 7.5v9l9 5.25m0-9v9"
            />
          </svg>
        </div>
        <div className="flex items-center">
          <div className="">
            <h1 className="font-semibold text-xl">{item.title}</h1>
            <p className="">{item.description !== null && item.description}</p>
          </div>
        </div>
      </div>
      {children}
    </div>
  );
}

export default Card;
