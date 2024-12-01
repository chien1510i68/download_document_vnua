import { Button } from "antd";
import React, { useState } from "react";
import ModalDetail from "../modal/ModalDetail";

export default function SubjectDetail({ data }) {
  const colors = [
    "bg-gradient-to-br from-red-500 to-yellow-500",
    "bg-gradient-to-br from-yellow-500 to-green-500",
    "bg-gradient-to-br from-green-500 to-blue-500",
    "bg-gradient-to-br from-blue-500 to-purple-500",
    "bg-gradient-to-br from-purple-500 to-pink-500",
    "bg-gradient-to-br from-pink-500 to-red-500",
    "bg-gradient-to-br from-indigo-500 to-blue-500",
    "bg-gradient-to-br from-teal-500 to-green-500",
    "bg-gradient-to-br from-gray-500 to-black",
    "bg-gradient-to-br from-blue-700 to-blue-500",
    "bg-gradient-to-br from-amber-500 to-pink-500",
    "bg-gradient-to-br from-orange-500 to-yellow-500",
    "bg-gradient-to-br from-cyan-400 to-blue-500",
    "bg-gradient-to-br from-teal-300 to-green-400",
    "bg-gradient-to-br from-lime-500 to-yellow-500",
    "bg-gradient-to-br from-fuchsia-500 to-purple-500",
    "bg-gradient-to-br from-indigo-400 to-teal-500",
    "bg-gradient-to-br from-red-400 to-orange-500",
    "bg-gradient-to-br from-sky-500 to-indigo-500",
    "bg-gradient-to-br from-blue-800 to-indigo-900",
    "bg-gradient-to-br from-yellow-400 to-teal-500",
    "bg-gradient-to-br from-gray-400 to-blue-400",
    "bg-gradient-to-br from-violet-500 to-purple-700",
    "bg-gradient-to-br from-green-600 to-yellow-500",
    "bg-gradient-to-br from-blue-600 to-cyan-400",
    "bg-gradient-to-br from-teal-600 to-blue-700",
    "bg-gradient-to-br from-red-600 to-orange-600",
    "bg-gradient-to-br from-orange-700 to-yellow-700",
    "bg-gradient-to-br from-cyan-500 to-teal-400",
    "bg-gradient-to-br from-pink-400 to-purple-400",
    "bg-gradient-to-br from-yellow-600 to-red-700",
    "bg-gradient-to-br from-blue-400 to-sky-500",
    "bg-gradient-to-br from-pink-500 via-orange-500 to-red-500",
    "bg-gradient-to-br from-emerald-400 to-teal-500",
    "bg-gradient-to-br from-gray-600 to-black",
    "bg-gradient-to-br from-rose-400 to-teal-500",
    "bg-gradient-to-br from-teal-500 via-emerald-500 to-green-600",
    "bg-gradient-to-br from-indigo-500 via-cyan-500 to-blue-600",
    "bg-gradient-to-br from-red-300 via-orange-400 to-yellow-500",
    "bg-gradient-to-br from-fuchsia-600 to-violet-700",
    "bg-gradient-to-br from-green-500 to-lime-500",
    "bg-gradient-to-br from-blue-500 via-sky-500 to-indigo-600",
    "bg-gradient-to-br from-yellow-500 via-orange-500 to-red-500",
    "bg-gradient-to-br from-blue-500 via-indigo-500 to-purple-500",
    "bg-gradient-to-br from-cyan-500 via-teal-400 to-green-500",
    "bg-gradient-to-br from-pink-500 to-rose-500",
    "bg-gradient-to-br from-amber-400 to-teal-500",
    "bg-gradient-to-br from-lime-400 to-yellow-400",
    "bg-gradient-to-br from-gray-400 to-black",
    "bg-gradient-to-br from-cyan-400 to-blue-700",
    "bg-gradient-to-br from-indigo-600 to-pink-500"
];

  const randomColor = colors[Math.floor(Math.random() * colors.length)]; // Chọn màu ngẫu nhiên
  const [openModal, setOpenModal] = useState(false);
  const onCancel = () => {
    setOpenModal(false);
  };

  return (
    <div
      className={`col-span-1 w-full h-[25vh] bg-slate-600 mx-auto text-center rounded-lg ${randomColor} relative `}
    >
      <div className="absolute top-1/2 left-1/2 translate-x-[-50%] translate-y-[-50%]">
        <h2 className="text-zinc-100 font-semibold pt-3">{data?.name}</h2>
        <p className="text-zinc-100 font-medium my-auto block py-3">
          Tổng {data?.documents?.length} tài liệu
        </p>
        <div className="flex gap-2 pt-2">
          {/* <Button className=" border-none hover:!bg-green-400 hover:!text-gray-300 font-semibold ">Dowload</Button> */}
          <Button className=" border-none bg-green-400 text-gray-50 font-semibold block  mx-auto" onClick={() => setOpenModal(true)}>
            Xem chi tiết
          </Button>
        </div>
      </div>
      <ModalDetail open={openModal} onCancel={onCancel} listData={data?.documents} name ={data.name}/>
    </div>
  );
}
