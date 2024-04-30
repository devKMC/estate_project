import { create } from 'zustand';

interface UserStore {
    role: string,
    setRole: (role: string) => void, //함수로 지정
}

const useUserStore = create<UserStore>(set => ({
    role: '',
    setRole: (role: string) => set(state => ({ ...state, role }))
}));

export default useUserStore;