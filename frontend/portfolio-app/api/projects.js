// Serverless function file for project endpoints

module.exports = async (req, res) => {

    const backendUrl = "https://portfolio2-git-main-olsonja88.vercel.app/api";

    const apiEndpoint = `/projects${req.url}`;

    try {

        let response;

        if (req.method === 'GET') {
            response = await fetch(`${backendUrl}${apiEndpoint}`);
        } else if (req.method === 'POST' || req.method === 'PUT' || req.method === 'DELETE') {
            response = await fetch(`${backendUrl}${apiEndpoint}`, {
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
        res.status(500).json({ error: "An error occurred while processing the request." });
    }
};