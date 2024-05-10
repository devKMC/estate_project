import React, { useState } from "react";
import './style.css'
import SelectBox from 'src/components/selectbox';
import { BarElement, CategoryScale, Chart as ChartJS, Legend, LineElement, LinearScale, PointElement, Tooltip } from "chart.js";
import { Bar, Line } from "react-chartjs-2";
import { useCookies } from "react-cookie";
import { getRatioDataRequest } from "src/apis/estate";
import ResponseDto from "src/apis/response.dto";
import { GET_RATIO_DATA_URL } from "src/constant";
import { useNavigate } from "react-router";
import { GetRatioDataResponseDto } from "src/apis/estate/dto/response";


ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    BarElement,
    Tooltip,
    Legend
);

export default function Ratio() {

    const returnOptions = {
        responsive: false,

    };

    const leaseRatioOptions = {
        responsive: false,

    };

    const monthRentRatioOptions = {
        responsive: false,

    };

    //                                       state                                           //
    const [selectLocal, setSelectLocal] = useState<string>('');
    const [cookies] = useCookies();
    const [yearMonth, setYearMonth] = useState<String[]>([]);

    const [return40, setReturn40] = useState<number[]>([]);
    const [return4060, setReturn4060] = useState<number[]>([]);
    const [return6085, setReturn6085] = useState<number[]>([]);
    const [return85, setReturn85] = useState<number[]>([]);
    const [leaseRatio40, setLeaseRatio40] = useState<number[]>([]);
    const [leaseRatio4060, setLeaseRatio4060] = useState<number[]>([]);
    const [leaseRatio6085, setLeaseRatio6085] = useState<number[]>([]);
    const [leaseRatio85, setLeaseRatio85] = useState<number[]>([]);
    const [monthRenteRatio40, setMonthRenteRatio40] = useState<number[]>([]);
    const [monthRenteRatio4060, setMonthRenteRatio4060] = useState<number[]>([]);
    const [monthRenteRatio6085, setMonthRenteRatio6085] = useState<number[]>([]);
    const [monthRenteRatio85, setMonthRenteRatio85] = useState<number[]>([]);
    //                                       function                                           //

    const GetRationDataResponse = (result: GetRatioDataResponseDto|ResponseDto | null) => {
        const message = 
            !result ? '서버에 문제가 있습니다.':
            result.code ==='VF' ? '제목과 내용을 모두 입력해주세요.':
            result.code ==='AF' ? '권한이 없습니다.' :
            result.code === 'DBE' ? '서버에 문제가 있습니다':'';

        if (!result || result.code !== 'SU'){
            alert(message);
            return;
        }

        const {
            yearMonth,
            return40, return4060,return6085,return85,
            leaseRatio40,leaseRatio6085,leaseRatio4060,leaseRatio85,
            monthRenteRatio40,monthRenteRatio4060,monthRenteRatio6085,monthRenteRatio85
        } = result as GetRatioDataResponseDto;

        setYearMonth(yearMonth);
        setReturn40(return40);
        setReturn4060(return4060);
        setReturn6085(return6085);
        setReturn85(return85);

        setLeaseRatio40(leaseRatio40);
        setLeaseRatio4060(leaseRatio4060);
        setLeaseRatio6085(leaseRatio6085);
        setLeaseRatio85(leaseRatio85);


        setMonthRenteRatio40(monthRenteRatio40);
        setMonthRenteRatio4060(monthRenteRatio4060);
        setMonthRenteRatio6085(monthRenteRatio6085);
        setMonthRenteRatio85(monthRenteRatio85);


    };
    //                                       event handler                                           //
    const onLocalChangeHandler = (selectLocal: string) => {
        setSelectLocal(selectLocal);
    };


    
    const onSearchClickHandler = () => {
        if (!selectLocal || !cookies.accessToken ) return;
        getRatioDataRequest(selectLocal,cookies.accessToken).then(GetRationDataResponse);
    }
    const returnData =
        {
            labels: yearMonth,
            datasets: [
                {
                    label: '40 이하',
                    data: return40,
                    borderColor: 'rgba(58, 87, 232, 1)',
                    backgroundColor: 'rgba(58, 87, 232, 1)'
                },
                {
                    label: '40 초과 60이하',
                    data: return4060,
                    borderColor: 'rgba(0, 203, 93, 1)',
                    backgroundColor: 'rgba(0, 203, 93, 1)'
                },
                {
                    label: '60 초과 85이하',
                    data: return6085,
                    borderColor: 'rgba(255, 168, 0, 1)',
                    backgroundColor: 'rgba(255, 168, 0, 1)'
                },
                {
                    label: '85 초과',
                    data: return85,
                    borderColor: 'rgba(255, 84, 64, 1)',
                    backgroundColor: 'rgba(255, 84, 64, 1)'
                }
            ]
        };

        const leaseRatioData =
        {
            labels: yearMonth,
            datasets: [
                {
                    label: '40 이하',
                    data: leaseRatio40,
                    borderColor: 'rgba(58, 87, 232, 1)',
                    backgroundColor: 'rgba(58, 87, 232, 1)'
                },
                {
                    label: '40 초과 60이하',
                    data: leaseRatio4060,
                    borderColor: 'rgba(0, 203, 93, 1)',
                    backgroundColor: 'rgba(0, 203, 93, 1)'
                },
                {
                    label: '60 초과 85이하',
                    data: leaseRatio6085,
                    borderColor: 'rgba(255, 168, 0, 1)',
                    backgroundColor: 'rgba(255, 168, 0, 1)'
                },
                {
                    label: '85 초과',
                    data: leaseRatio85,
                    borderColor: 'rgba(255, 84, 64, 1)',
                    backgroundColor: 'rgba(255, 84, 64, 1)'
                }
            ]
        };

        const monthRentRatioData =
        {
            labels: yearMonth,
            datasets: [
                {
                    label: '40 이하',
                    data: monthRenteRatio40,
                    borderColor: 'rgba(58, 87, 232, 1)',
                    backgroundColor: 'rgba(58, 87, 232, 1)'
                },
                {
                    label: '40 초과 60이하',
                    data:monthRenteRatio4060,
                    borderColor: 'rgba(0, 203, 93, 1)',
                    backgroundColor: 'rgba(0, 203, 93, 1)'
                },
                {
                    label: '60 초과 85이하',
                    data: monthRenteRatio6085,
                    borderColor: 'rgba(255, 168, 0, 1)',
                    backgroundColor: 'rgba(255, 168, 0, 1)'
                },
                {
                    label: '85 초과',
                    data: monthRenteRatio85,
                    borderColor: 'rgba(255, 84, 64, 1)',
                    backgroundColor: 'rgba(255, 84, 64, 1)'
                }
            ]
        };

    //                                       render                                           //
        const returnFlag = !!return40.length && !! !!return4060.length || !!return6085|| !!return85 ;
        const leaseRatioFlag = !!leaseRatio40.length && !! !!leaseRatio4060.length || !!leaseRatio6085|| !!leaseRatio85 ;
        const MonthRentRatioFlag = !!monthRenteRatio40.length && !! !!monthRenteRatio4060.length || !!monthRenteRatio6085|| !!monthRenteRatio85 ;

        const buttonClass = selectLocal ? 'primary-button' : 'disable-button';



    return(
        <div id="local-wrapper">
            <div className="local-top">
                <div className="local-search-box">
                    <SelectBox value={selectLocal} onChange={onLocalChangeHandler} />
                    <div className={buttonClass} onClick={onSearchClickHandler}>검색</div>
                </div>
                <div className="local-origin-text">데이터 출처: KOSIS</div>
            </div>
            {!returnFlag && !leaseRatioFlag && !MonthRentRatioFlag &&
            <div className='local-no-data-text'>검색 결과가 없습니다.</div>
            }
            {returnFlag &&
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">수익률 평균</div>
                    <div className="local-card-unit">(단위: %)</div>
                </div>
                <div className="local-card-chart-box">
                    <Line width={'1086px'} height={'238px'} options={returnOptions} data={returnData} />
                </div>
            </div>
            }
            {leaseRatioFlag &&
            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">매매가격 대비 전세 비율</div>
                    <div className="local-card-unit">(단위: %)</div>
                </div>
                <div className="local-card-chart-box">
                    <Bar width={'1086px'} height={'238px'} options={leaseRatioOptions} data={leaseRatioData}/>
                </div>
            </div>
            }
            {!MonthRentRatioFlag &&

            <div className="local-card">
                <div className="local-card-title-box">
                    <div className="local-card-title">전세가격 대비 월세 보증금 비율</div>
                    <div className="local-card-unit">(단위: %)</div>
                </div>
                <div className="local-card-chart-box">
                    <Line width={'1086px'} height={'238px'} options={monthRentRatioOptions} data={monthRentRatioData}/>
                </div>
            </div>
            }
        </div>
    );
}