import { useRef } from "react";

function Modal({ hideModal, children }) {
  const backContent = useRef();

  const handleClick = (e) => {
    if (e.target.contains(backContent.current)) hideModal();
  };

  return (
    <div
      className="fixed top-0 left-0 z-20 w-full h-full bg-black/50 grid place-items-center"
      ref={backContent}
      onClick={(e) => handleClick(e)}
    >
      <div className="w-6/12 bg-gray-50 rounded-2xl h-[400px] relative animate-slideDown">
        <button
          onClick={(e) => hideModal()}
          className="absolute w-8 cursor-pointer right-0 top-0 mr-2 mt-2 text-gray-800"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="w-6 h-6"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M6 18L18 6M6 6l12 12"
            />
          </svg>
        </button>

        {children}
      </div>
    </div>
  );
}

export default Modal;
