function Alert({ type, content }) {
  const mapType = {
    info: {
      style: "border-blue-700 text-blue-700 bg-blue-200/40",
      icon: (
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          strokeWidth={1.5}
          stroke="currentColor"
          className="w-8 h-8"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            d="M11.25 11.25l.041-.02a.75.75 0 011.063.852l-.708 2.836a.75.75 0 001.063.853l.041-.021M21 12a9 9 0 11-18 0 9 9 0 0118 0zm-9-3.75h.008v.008H12V8.25z"
          />
        </svg>
      ),
    },
  };

  const propsType = mapType[type];

  return (
    <div
      className={`border ${propsType.style} rounded-md shadow-sm py-3 px-5 flex items-center gap-x-2 w-[300px] select-none animate-slideDown`}
    >
      {propsType.icon}
      <h2 className="text-black font-medium text-lg">{content}</h2>
    </div>
  );
}

export default Alert;
