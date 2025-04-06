const express = require('express');
const cors = require('cors');
const app = express();
const turnosRoutes = require('./turnos.routes');

app.use(cors());
app.use(express.json());

app.use('/api/turnos', turnosRoutes);

const PORT = process.env.PORT || 3001;
app.listen(PORT, () => {
  console.log(`Servidor corriendo en el puerto ${PORT}`);
});
