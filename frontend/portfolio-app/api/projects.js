// Serverless function file for project endpoints

module.exports = async (req, res) => {

    res.setHeader('Access-Control-Allow-Origin', 'https://portfolio2-ten-kohl.vercel.app', 'https://johnolson.dev');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

    const backendUrl = 'https://frozen-dusk-55881-7ff3d5645692.herokuapp.com/api';

    const apiEndpoint = `${backendUrl}${req.url.startsWith('/') ? '' : '/'}${req.url}`;

    try {

        let response;

        if (req.method === 'GET') {
            response = await fetch(apiEndpoint);
        } else if (req.method === 'POST' || req.method === 'PUT' || req.method === 'DELETE') {
            response = await fetch(apiEndpoint, {
                method: req.method,
                headers: req.headers,
                body: req.method !== 'GET' ? req.body: undefined
            });
        } else {
            res.status(400).json({ error: 'Invalid request method.' });
            return;
        }

        res.status(response.status);
        res.json(await response.json());

    } catch (error) {
        res.status(500).json({ error: `${error}`});
    }
};
