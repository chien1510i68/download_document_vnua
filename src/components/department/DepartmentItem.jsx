"use client";
import React, { useState } from "react";
import CourseItem from "../courses/CourseItem";
import ModalDetail from "../modal/ModalDetail";
import { Button, notification } from "antd";

export default function DepartmentItem({ data }) {
  const [visibleItems, setVisibleItems] = useState(4);
  const [subject , setSubject] = useState(null);
  const [openModal , setOpenModal] = useState(false);

  const handleSeeMore = () => {
    setVisibleItems((prev) => prev + 4);
  };

  const handleSeeLess = () => {
    setVisibleItems(4);
  };

  const handleSeeAll = () => {
    setVisibleItems(data?.length);
  };
  const handleClick = (data) =>{
    setOpenModal(true)
    setSubject(data)
  }
  return (
    <div className="my-5">
      <h2 className="font-title font-medium text-2xl mt-8 mb-3">{data?.departmentName}</h2>
      <div className="grid laptop:grid-cols-4 tablet:grid-cols-2 phone:grid-cols-1 gap-7 ">
        {data &&
          data?.subjects?.slice(0, visibleItems)?.map((subject, index) => (
            <div
              key={index}
              className="col-span-1 w-full first:ml-0 block last:mr-0"
              onClick={() => handleClick(subject)}
            >
              <CourseItem data={subject} />
            </div>
          ))}
      </div>
      <div className="flex">
        {visibleItems < data?.subjects.length && (
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

        {visibleItems < data?.subjects?.length && (
          <div className="mt-4">
            <Button
              onClick={handleSeeAll}
              className="px-4 py-2 border-[2px] border-solid border-[#e8eef7] rounded-md "
            >
              Show All
            </Button>
          </div>
        )}
      </div>
      <ModalDetail open={openModal} data={subject} onCancel={() => setOpenModal(false)}/>
    </div>
  );
}
