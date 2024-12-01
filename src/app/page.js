import Department from "@/components/department/Department";
import News from "@/components/news/News";
import UploadDocument from "@/components/orther/UploadDocument";
import { Image } from "antd";
export default function Home() {
  return (
    <div className="">
      <div className="h-[50vh] bg-[url('/banner.jpg')] bg-cover bg-center mt-16 relative">
        {/* <Image
          preview={false}
          src="/banner.jpg"
          style={{ width: "100vw", height: "50vh", objectFit: "cover" }}
        /> */}
        <h2 className="font-desc font- text-slate-100 text-4xl absolute top-1/2 left-1/4 translate-x-[-30%] leading-10">
          Xem và tải tài liệu các môn học trong chương trình
          <br /> của Học viện nông nghiệp Việt Nam
        </h2>
      </div>
      <div className="max-w-[1440px] mx-auto">
        <div>
          <h2 className="my-5 font-title text-2xl font-medium">Thêm tài liệu để được nhận thưởng </h2>
          <div className="p-4 border-[2px] border-solid border-[#e8eef7] rounded-lg">
            <UploadDocument />
          </div>
        </div>
        <News />

        <Department />
      </div>
    </div>
  );
}
