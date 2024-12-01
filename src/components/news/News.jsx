"use client"
import React, { useEffect, useState } from "react";
import NewItem from "./NewItem";
import { getAllNews } from "../api/apiNews";
import { Button } from "antd";

export default function News() {
  const [listNew, setListNew] = useState([
    {
      title:
        "Thông báo tổ chức kỳ thi Chuẩn đầu ra Tin học của Học viện đợt tháng 12 năm 2024",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1831",
      date: "(28/11/2024)",
    },
    {
      title:
        "Thông báo danh sách sinh viên khóa 61- khóa 66 chưa đạt Chuẩn đầu ra Kỹ năng mềm... (26/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1830",
      date: "26/11/2024",
    },
    {
      title:
        "Thông báo danh sách sinh viên dự kiến đạt Chuẩn đầu ra Tin học Đợt tháng 11.2024... (22/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1829",
      date: "22/11/2024",
    },
    {
      title:
        "Thông báo v/v nghỉ giảng dạy và học tập sáng ngày 19 tháng 11 năm 2024... (14/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1828",
      date: "14/11/2024",
    },
    {
      title:
        "Thông báo V/v thu tiền học phí Đợt 2, học kì I, năm học 2024-2025 đối với SINH VIÊN... (11/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1825",
      date: "11/11/2024",
    },
    {
      title:
        "Thông báo tiếp nhận giải quyết thủ tục hành chính sinh viên... (11/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1824",
      date: "11/11/2024",
    },
    {
      title:
        "Thông báo điều chỉnh lịch tổ chức lễ bế giảng và trao bằng tốt nghiệp bậc đại học hệ đào tạo chính quy công nhận tốt nghiệp tháng 8/2024... (08/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1823",
      date: "08/11/2024",
    },
    {
      title:
        "Thông báo V/v tổ chức lễ bế giảng và trao bằng tốt nghiệp, bậc đào tạo Đại học hệ đào tạo chính quy công nhận tốt nghiệp tháng 8/2024... (06/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1822",
      date: "06/11/2024",
    },
    {
      title:
        "Thông báo danh sách sinh viên được công nhận tốt nghiệp trình độ Đại học tháng 09 năm 2024... (05/11/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1821",
      date: "05/11/2024",
    },
    {
      title:
        "Thông báo về việc tổ chức đánh giá trình độ tiếng Anh đầu vào cho sinh viên khóa 69... (25/10/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1820",
      date: "25/10/2024",
    },
    {
      title:
        "Thông báo tổ chức kỳ thi Chuẩn đầu ra Tin học của Học viện đợt tháng 10 năm 2024... (25/10/2024)",
      url: "https://daotao.vnua.edu.vn/default.aspx?page=chitietthongtin&id=1819",
      date: "25/10/2024",
    },
  ]);

  const [visibleItems, setVisibleItems] = useState(4); // Số lượng tin hiển thị ban đầu

  // Hàm để xử lý sự kiện khi nhấn "See more"
  const handleSeeMore = () => {
    setVisibleItems((prev) => prev + 4); // Mỗi lần nhấn "See more" sẽ thêm 4 tin
  };

  // Hàm để xử lý sự kiện khi nhấn "See less"
  const handleSeeLess = () => {
    setVisibleItems(4); // Khi nhấn "See less", giảm số lượng tin xuống còn 4
  };

  // Hàm để xử lý sự kiện khi nhấn "See all"
  const handleSeeAll = () => {
    setVisibleItems(listNew.length); // Hiển thị tất cả tin
  };

  useEffect(() => {
    const fetchData = async () => {
      const data = await getAllNews();
      setListNew(data); // Cập nhật danh sách tin tức từ API
    };
    fetchData();
  }, []);

  return (
    <div>
      <h2 className="mt-10 mb-2 font-title font-medium text-2xl">Tin tức mới nhất</h2>
      <div className="grid laptop:grid-cols-4 tablet:grid-cols-2 phone:grid-cols-1 gap-7 ">
        {listNew.slice(0, visibleItems).map((item, index) => (
          <div
            key={index}
            className="col-span-1 w-full first:ml-0 block last:mr-0"
          >
            <NewItem data={item} />
          </div>
        ))}
      </div>

      <div className="flex">
        {visibleItems < listNew.length && (
          <div className="mt-4">
            <Button
              onClick={handleSeeMore}
              className="px-4 py-2 bg-blue-500 text-white rounded-md mr-4"
            >
              Show More
            </Button>
          </div>
        )}

        {visibleItems > 4 && (
          <div className="mt-4">
            <Button
              onClick={handleSeeLess}
              className="px-4 py-2 bg-yellow-500 text-white rounded-md mr-4"
            >
              Show Fewer
            </Button>
          </div>
        )}

        {visibleItems < listNew.length && (
          <div className="mt-4">
            <Button
              onClick={handleSeeAll}
              className="px-4 py-2 border-[2px] border-solid border-[#e8eef7] rounded-md hover:bg-[#94a3b81c]"
            >
              Show All
            </Button>
          </div>
        )}
      </div>
    </div>
  );
}
