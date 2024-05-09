import React, { useState } from 'react';
import './style.css'
import SelectBox from 'src/components/selectbox';
import {  CategoryScale, Chart as ChartJS,  LineElement, LinearScale, PointElement, Title, Tooltip } from 'chart.js';
import { Line } from 'react-chartjs-2';

ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
);



//                                       component                                           //
export default function Local() {

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top' as const,
            },
            title: {
                display: true,
                text: 'Chart.js Bar Chart',
            },
    }
}
    //                                       state                                           //
    const [selectLocal, setSelectLocal] = useState<string>('');

    //                                       event handler                                           //
    const onLocalChangeHandler = (selectLocal: string) => {
        setSelectLocal(selectLocal);
    };

    const saleData = 
        {
            labels: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12',],
            datasets:[{
                labels: '매매 평균',
                data: [225, 224, 224, 224, 200, 210, 220, 230, 240, 250, 260, 270],
                borderColor: 'rgba(58,87,232,1)',
                backgroundColor: 'rgba(53, 162, 235, 0.5)'
            }]
        }
    
        const leaseData = 
        {
            labels: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12',],
            datasets:[{
                labels: '전세 평균',
                data: [225, 224, 224, 224, 200, 210, 220, 230, 240, 250, 260, 270],
                borderColor: 'rgba(58,87,232,1)',
                backgroundColor: 'rgba(53, 162, 235, 0.5)'
            }]
        }
    
        const monthData = 
        {
            labels: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12',],
            datasets:[{
                labels: '월세 평균',
                data: [225, 224, 224, 224, 200, 210, 220, 230, 240, 250, 260, 270],
                borderColor: 'rgba(58,87,232,1)',
                backgroundColor: 'rgba(53, 162, 235, 0.5)'
            }]
        }
    

    //                                       render                                           //
    return (
        <div id="local-wrapper">
            <div className="local-top">
                <div className="local-search-box">
                    <SelectBox value={selectLocal} onChange={onLocalChangeHandler} />
                    <div className="primary-button">검색</div>
                </div>
                <div className="local-origin-text">데이터 출처: KOSIS</div>
            </div>
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">매매 평균</div>
                    <div className="local-card-unit">(단위: 백만원)</div>
                </div>
                <div className="lcoal-card-chart-box">
                    <Line  options={options} data={saleData}></Line>
                </div>
            </div>
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">전세 평균</div>
                    <div className="local-card-unit">(단위: 백만원)</div>
                </div>
                <div className="lcoal-card-chart-box">
                    <Line  options={options} data={leaseData}></Line>
                </div>
            </div>
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">월세 평균</div>
                    <div className="local-card-unit">(단위: 백만원)</div>
                </div>
                <div className="lcoal-card-chart-box">
                    <Line  options={options} data={monthData}></Line>
                </div>
            </div>
        </div>
    );
}