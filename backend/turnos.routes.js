const express = require('express');
const router = express.Router();
const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();

// POST /api/turnos
router.post('/', async (req, res) => {
  try {
    const { dia, hora, nombreClienta, observacion } = req.body;

    const nuevoTurno = await prisma.turno.create({
      data: {
        dia: new Date(dia),
        hora,
        nombreClienta,
        observacion,
      },
    });

    res.status(201).json(nuevoTurno);
  } catch (error) {
    console.error('Error al guardar el turno:', error);
    res.status(500).json({ error: 'Error al guardar el turno' });
  }
});

// GET /api/turnos
router.get('/', async (req, res) => {
  try {
    const turnos = await prisma.turno.findMany();
    res.json(turnos);
  } catch (error) {
    console.error('Error al obtener turnos:', error);
    res.status(500).json({ error: 'Error al obtener turnos' });
  }
});

module.exports = router;

