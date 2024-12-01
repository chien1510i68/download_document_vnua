import { Modal } from "antd";
import React, { useState } from "react";

export default function ModalDetail({ open, onCancel,data}) {
  const [selectedDocument, setSelectedDocument] = useState(null); // Trạng thái để lưu tài liệu được chọn

  return (
    <Modal
      open={open}
      footer={null}
      onCancel={onCancel}
      destroyOnClose={true}
      width={1200}
      // height={600}
    >
       <h2 className=" text-center text-2xl mb-5">
            Tài liệu chi tiết môn học {data?.name}
          </h2>
     
      <div className="grid grid-cols-7">
      
          <div 
          // key={subject.key}
           className="subject mb-2 col-span-2 ">
            <h2 className="text-center pt-4 text-lg">Danh sách tài liệu </h2>
           
            <ul className="pt-2">
              {data?.documents.map((doc, index) => (
                <li key={index}>
                  <a
                    href="#"
                    onClick={(e) => {
                      e.preventDefault(); // Ngăn chuyển trang khi nhấp vào link
                      setSelectedDocument(doc); // Cập nhật tài liệu được chọn
                    }}
                    // Thêm class `text-blue-500` nếu tài liệu này là tài liệu được chọn
                    className={`text-center block py-2 ${
                      selectedDocument === doc ? "text-blue-500 font-semibold" : ""
                    }`}
                    
                  >
                    {doc.title}
                  </a>
                </li>
              ))}
            </ul>
        
        </div>

        <div className="col-span-5 w-full shadow-sm h-[80vh] shadow-slate-400">
         
          {selectedDocument ? (
            <div className="p-4">
              <h3 className="mb-5 text-lg text-center">{selectedDocument.title}</h3>
              <iframe
                src={selectedDocument.link}
                width="100%"
                height="600px"
                title="Document Viewer"
              ></iframe>
            </div>
          ) : (
            <p className="text-center pt-10 text-red-500 text-xl">Chọn một tài liệu để xem chi tiết</p>
          )}
        </div>
      </div>
    </Modal>
  );
}
