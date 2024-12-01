/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
    "./node_modules/flowbite/**/*.js",
  ],
  theme: {
    extend: {
      spacing: {
        100: "100px", // Thêm giá trị tùy chỉnh nếu chưa có
      },
      screens: {
        phone: "260px",
        tablet: "640px",
        // => @media (min-width: 640px) { ... }

        laptop: "1024px",
        // => @media (min-width: 1024px) { ... }

        desktop: "1280px",
        // => @media (min-width: 1280px) { ... }
      },
      colors: {
        background: "#ffffff",
        foreground: "var(--foreground)",
        text: "",
      },
      fontFamily: {
        logo: ["Vibur", "SUSE", "Roboto"],
        title: ["Roboto", "SUSE", "Montserrat"],
        desc: ["Montserrat", "SUSE", "Roboto"],
      },
    },
  },
  plugins: [
    // require('flowbite/plugin'),
    require("tailwindcss-animated"),
  ],
};
