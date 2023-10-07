/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      animation: {
        slideDown: 'slideDown .6s ease-in-out'
      }
    },
  },
  plugins: [],
}

