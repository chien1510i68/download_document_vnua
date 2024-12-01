import { Image } from "antd";

export default function CourseItem({ data }) {
  return (
    <div
      className="border-[2px] border-solid border-[#e8eef7] bg-[#ffffff] rounded-lg p-2 cursor-pointer 
      transition-transform duration-300 ease-in-out hover:-translate-y-1 hover:scale-105 
      hover:shadow-lg hover:shadow-[#85858f6b]"
    >
      <div className="text-center w-full ">
        <Image src="/icon_document.png" preview={false} style={{height : "150px"}} />
      </div>
      <div className="my-3">
        {/* <Image src="/icon_notification.png" preview={false} style={{width : "40px" , color : "red"}}/> */}
        <h2 className="line-clamp-1 font-desc text-center ">{data?.name}</h2>
      
      </div>
    </div>
  );
}
