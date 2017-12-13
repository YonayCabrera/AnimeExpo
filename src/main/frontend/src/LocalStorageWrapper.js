export default function storageWrapper(){
    const userKey = 'user';
    return {
        setUser: (user) => {
            localStorage.setItem(userKey, JSON.stringify(user));
        },
        getUser: () => {
            return JSON.parse(localStorage.getItem(userKey) === null ? '{}' : localStorage.getItem(userKey));
        },
        resetUser: () => {
            localStorage.removeItem(userKey);
        }
    };
}