import "whatwg-fetch";

const RestClient = () => {

    function headers() {
        return {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        };
    }

    function doRequest(method, url, content = undefined) {
        return fetch(url, {
            method: method,
            headers: headers(),
            body: JSON.stringify(content),
            credentials: 'same-origin'
        }).catch((error) => {
            return Promise.reject({message: 'Network problem:' + error.toString()});
        }).then(parseStatusCode)
            .then(parseJsonResponse);
    }

    function parseStatusCode(response) {
        let successStatusCodes = [200, 203];

        if (successStatusCodes.includes(response.status)) {
            return Promise.resolve(response);
        } else {
            let error = generateServerError(response);
            return Promise.reject(error);
        }
    }

    function generateServerError(response) {
        return new Error(response.statusText + '(' + response.status + ')');
    }

    function parseJsonResponse(response) {
        try {
            return Promise.resolve(response.json());
        } catch (exception) {
            let message = 'Client is expecting JSON but server is returning HTML. Are you sure you are running the right backend?';
            /* eslint-disable */
            console.error(message);
            /* eslint-enable */
            return Promise.reject({message});
        }
    }

    return {
        doGet: (url) => doRequest('GET', url),
        doPost: (url, body) => doRequest('POST', url, body)
    };
};

export default RestClient;