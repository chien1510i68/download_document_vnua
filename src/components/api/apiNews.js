export const getAllNews = async () => {
  // const response = await fetch('https://service.edustar.com.vn/news/all');
  const response = await fetch('https://edustar.com.vn/UniScheduleService01/api/v1/news', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
    mode: 'cors', // Đảm bảo fetch sử dụng chế độ CORS
  });
  
  if (!response.ok) {
    throw new Error("Failed to fetch data");
  }
  const data = await response.json();
  console.log("data : ", data);
  return data;
};
