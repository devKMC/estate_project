import React, { useState } from 'react';
import './style.css';
import SelectBox from 'src/components/selectbox';
import {  BarElement, CategoryScale, Chart as ChartJS,  Legend,  LineElement, LinearScale, PointElement, Ticks, Title, Tooltip } from 'chart.js';
import { Bar, Line } from 'react-chartjs-2';


ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    BarElement,
    Tooltip,
    Legend
);


//                                       component                                           //
export default function Ratio() {
    
    const returnOptions = {
        responsive: false,
        scales: {
            y: {
                min:150,
                max:300,
                ticks: {
                    stepSize:30
                }
            }
        }
    }

    const leaseRatiooptions = {
        responsive: false,
        scales: {
            y: {
                min:150,
                max:300,
                ticks: {
                    stepSize:30
                }
            }
        }
    }

    const monthRatiooptions = {
        responsive: false,
        scales: {
            y: {
                min:150,
                max:300,
                ticks: {
                    stepSize:30
                }
            }
        }
    }
    //                                       state                                           //
    const [selectLocal, setSelectLocal] = useState<string>('');



    //                                       event handler                                           //

    const onLocalChangeHandler = (selectLocal: string) => {
        setSelectLocal(selectLocal);
    };

    const ReturnRatioData = 
        {
            labels: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12',],
            datasets:[{
                labels: '매매 평균',
                data: [225, 224, 224, 224, 200, 210, 220, 230, 240, 250, 260, 270],
                borderColor: 'rgba(58,87,232,1)',
                backgroundColor: 'rgba(53, 162, 235, 0.5)'
            }]
        }
    
        const leaseRatioData = 
        {
            labels: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12',],
            datasets:[{
                labels: '전세 평균',
                data: [225, 224, 224, 224, 200, 210, 220, 230, 240, 250, 260, 270],
                borderColor: 'rgba(58,87,232,1)',
                backgroundColor: 'rgba(53, 162, 235, 0.5)'
            }]
        }
    
        const monthRatioData = 
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
    return(
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
                    <div className="local-card-title">수익률 평균</div>
                    <div className="local-card-unit">(단위: 백만원)</div>
                </div>
                <div className="lcoal-card-chart-box">
                    <Line width={'1086px'} height={'238px'} options={returnOptions} data={ReturnRatioData} />
                </div>
            </div>
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">매매가격 대비 전세 비율</div>
                    <div className="local-card-unit">(단위: 백만원)</div>
                </div>
                <div className="lcoal-card-chart-box">
                    <Bar width={'1086px'} height={'238px'} options={leaseRatiooptions} data={leaseRatioData} />
                </div>
            </div>
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">전세 가격 대비 월세 보증금 비율</div>
                    <div className="local-card-unit">(단위: 백만원)</div>
                </div>
                <div className="lcoal-card-chart-box">
                    <Line width={'1086px'} height={'238px'} options={monthRatiooptions} data={monthRatioData} />
                </div>
            </div>
        </div>
    )
}