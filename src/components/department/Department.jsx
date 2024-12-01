"use server";
import React from "react";
import DepartmentItem from "./DepartmentItem";
import CourseItem from "../courses/CourseItem";

async function getData() {
  const response = await fetch(
    "https://raw.githubusercontent.com/chien1510i68/document_data/main/data.json"
  );
  return response.json();
}

export default async function Department() {
  const data = await getData();
  console.log(data);

  return (
    <div>
      {data &&
        data?.map((item) => (
          <>
            <DepartmentItem data={item} />
          </>
        ))}
    </div>
  );
}
