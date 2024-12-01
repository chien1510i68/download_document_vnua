"use client";
import { useEffect, useState } from "react";

const Header = () => {
  const [lastScrollTop, setLastScrollTop] = useState(0);
  const [hidden, setHidden] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      const scrollTop =
        window.pageYOffset || document.documentElement.scrollTop;
      if (scrollTop > lastScrollTop) {
        setHidden(true); // Kéo xuống, ẩn header
      } else {
        setHidden(false); // Kéo lên, hiện header
      }
      setLastScrollTop(scrollTop <= 0 ? 0 : scrollTop); // Tránh giá trị âm
    };

    window.addEventListener("scroll", handleScroll);

    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, [lastScrollTop]);

  return (
    <header>
      <div
        className={`w-full py-5 bg-[#eeeff1] fixed transition-all duration-300 ease-in-out z-50 ${
          hidden ? "-top-[100px]" : "top-0"
        }`}
      >
        <div className="max-w-[1440px] mx-auto">
          <div className="flex justify-between  items-center">
            <h2 className="font-logo text-3xl max-w-full text-center   ">
              Document Dowload
            </h2>
            
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
