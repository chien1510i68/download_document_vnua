import { Image } from "antd";

export default function NewItem({ data }) {
  return (
    <div
      className="border-[2px] border-solid border-[#e8eef7] bg-[#ffffff] rounded-lg p-2 cursor-pointer 
      transition-transform duration-300 ease-in-out hover:-translate-y-1 hover:scale-105
      hover:shadow-lg hover:shadow-[#85858f6b]"
    >
      <div className="text-center w-full ">
        <Image src="/imgae_notification.png" preview={false} style={{height : "120px"}} />
      </div>
      <div className="my-3">
        {/* <Image src="/icon_notification.png" preview={false} style={{width : "40px" , color : "red"}}/> */}
        <h2 className="line-clamp-1 text-base">{data?.title}</h2>
        <h2 className=" text-left my-1 text-base">Ngày cập nhật : {data?.date}</h2>
        <a
          className="text-blue-300 hover:text-amber-800 text-base"
          href="https://daotao.vnua.edu.vn/default.aspx?page=danhsachthongtin&type=1"
        >
          Xem tất cả các thông báo
        </a>
      </div>
    </div>
  );
}
