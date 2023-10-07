function Card() {
  return (
    <div className="flex p-3 bg-white rounded-lg shadow-sm">
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
            <h1 className="font-semibold text-xl">Item1</h1>
            <p className="">Description</p>
          </div>
        </div>
      </div>
      <div className="flex items-center">
        <div className="flex flex-col items-center">
          <div className="flex gap-x-2 items-center">
            <h2 className="text-2xl font-semibold">99</h2>
            <h3>und</h3>
          </div>
          <span className="px-4 py-1 bg-gray-700 text-white rounded-full text-sm">
            state
          </span>
        </div>
      </div>
    </div>
  );
}

export default Card;
