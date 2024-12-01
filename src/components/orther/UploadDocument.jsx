"use client";
import { Button, message, Upload, Form, Input, Select } from "antd";
import { UploadOutlined } from "@ant-design/icons";

export default function UploadDocument() {
  const onFinish = (values) => {
    console.log("Success:", values);
  };
  const onFinishFailed = (errorInfo) => {
    console.log("Failed:", errorInfo);
  };
  const handleChange = (value) => {
    console.log(`selected ${value}`);
  };
  const props = {
    name: "file",
    action: "https://660d2bd96ddfa2943b33731c.mockapi.io/api/upload",
    headers: {
      authorization: "authorization-text",
    },
    onChange(info) {
      if (info.file.status !== "uploading") {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === "done") {
        message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === "error") {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
  };
  return (
    <div>
      <h2 className="text-center mb-10">Form khởi tạo thông tin tài liệu </h2>
      <Form
        name="basic"
        className="grid grid-cols-2 gap-10"
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
        autoComplete="off"
        layout="vertical"
      >
        <Form.Item
          className="col-span-1"
          label="Department"
          name="Department"
          rules={[
            {
              required: true,
              message: "Nhập khoa mà bạn muốn thêm tài liệu!",
            },
          ]}
        >
          <Select
            defaultValue="Công nghệ thông tin"
            placeholder="Nhập tên khoa có môn học bạn muốn thêm tài liệu!"
            onChange={handleChange}
            className="h-10"
            options={[
              {
                value: "Công nghệ thông tin",
                label: "Công nghệ thông tin",
              },
              {
                value: "Công nghệ sinh học",
                label: "Công nghệ sinh học",
              },
              {
                value: "Khoa học xã hội ",
                label: "Khoa học xã hội ",
              },
              {
                value: "Kế toán và Quản trị kinh doanh",
                label: "Kế toán và Quản trị kinh doanh",
              },
              {
                value: "Thú y",
                label: "Thú y",
              },
              {
                value: "Thủy sản",
                label: "Thủy sản",
              },
              {
                value: "Kinh tế và Phát triển nông thôn",
                label: "Kinh tế và Phát triển nông thôn",
              },
              {
                value: "Tài nguyên và môi trường",
                label: "Tài nguyên và môi trường",
              },
              {
                value: "Du lịch và ngoại ngữ",
                label: "Du lịch và ngoại ngữ",
              },
              {
                value: "Công nghệ thực phẩm",
                label: "Công nghệ thực phẩm",
              },
              {
                value: "Cơ - điện",
                label: "Cơ - điện",
              },
              {
                value: "Nông học",
                label: "Nông học",
              },
              {
                value: "Chăn nuôi",
                label: "Chăn nuôi",
              },
            ]}
          />
        </Form.Item>

        <Form.Item
          className="col-span-1"
          label="Môn học"
          name="subject"
          rules={[
            {
              required: true,
              message: "Nhập tên môn học muốn thêm tài liệu!",
            },
          ]}
        >
          <Input
            placeholder="Nhập tên môn học muốn thêm tài liệu!"
            className="rounded-md   h-10"
          />
        </Form.Item>
        <Form.Item
          className="col-span-1"
          label="Đường dẫn"
          name="link"
          rules={[
            {
              required: true,
              message: "Nhập đường dẫn tài liệu!",
            },
          ]}
        >
          <Input
            placeholder="Nhập đường dẫn tài liệu!"
            className="rounded-md   h-10"
          />
        </Form.Item>
        <Form.Item
          className="col-span-1 w-full"
          label="Đường dẫn"
          name="link"
         
        >
          <Upload {...props} className="w-full">
            <Button className="w-full" icon={<UploadOutlined />}>Click to Upload</Button>
          </Upload>
        </Form.Item>

        <Form.Item>
          <Button htmlType="submit">Submit</Button>
        </Form.Item>
      </Form>
    </div>
  );
}
